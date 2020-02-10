package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
    private int row;
    private int cell;
    private GameButton button;

    public GameActionListener(int row, int cell, GameButton gButton) {
        this.row = row;
        this.cell = cell;
        this.button = gButton;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameBoard board = button.getBoard();

        if (board.isTurnable(row, cell)) {
            updateByPlayersData(board);

            if (board.isFull()) {
                board.getGame().showMessage("Ничья!");
                board.emptyField();
            }
            else {
                if (!board.getGame().getCurrentPlayer().isRealPlayer()) {
                    updateByAiData(board);
                }
            }
        }
        else {
            board.getGame().showMessage("Некорректный ход!");
        }
    }

    public void updateByPlayersData(GameBoard board) {
        board.updateGameField(row, cell);
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Вы выиграли!");
            //board.emptyField();
        }
        else{
            board.getGame().passTurn();
        }
    }

    private void updateByAiData(GameBoard board) {
        // Генерация координат хода компьютера
        boolean turn = false;
        int x=-1, y=-1;

        //поиск двух и более ноликов для выигрыша
        if (!turn) {
            int[] location = findLocation(board, true);
            if (location[0] > -1 && location[0] > -1){
                x = location[0];
                y = location[1];
                turn = true;
            }
        }

        //поиск двух и более крестиков чтобы помешать игроку
        if (!turn) {
            int[] location = findLocation(board, false);
            if (location[0] > -1 && location[0] > -1){
                x = location[0];
                y = location[1];
                turn = true;
            }
        }

        //если предъидущие не прошли ставит в центр или если поле не 3*3 то приблизительно в центр
        if (!turn) {
            if (board.isTurnable(GameBoard.dimension / 2, GameBoard.dimension / 2)) {
                x = GameBoard.dimension / 2;
                y = GameBoard.dimension / 2;
                turn = true;
            }
        }

        // если центр занят ставит с случайную точку
        if (!turn) {
            Random rnd = new Random();
            do {
                x = rnd.nextInt(GameBoard.dimension);
                y = rnd.nextInt(GameBoard.dimension);
            } while (!board.isTurnable(x, y));
            turn = true;
        }

        // Обновим матрицу игры
        board.updateGameField(x, y);
        // Обновим содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if (board.checkWin()) {
            button.getBoard().getGame().showMessage("Компьютер выиграл!");
            board.getGame().passTurn();//Для корректоного старта игры 
           // board.emptyField();
        } else {
            board.getGame().passTurn();
        }
    }

    private int[] findLocation(GameBoard board, boolean AI){
        int[] location = new int[] {-1,-1};
        boolean turn = false;

        if (!turn)
            for (int mode : new int[]{1, 2, 3 , 4}) // обход всех режимов поиска 1-по вертикали 2-по горизонтали 3-диагональ 4-обратная диагональ
                if (!turn)
                    for (int i = 0; i < (mode < 3 ? GameBoard.dimension : 1); i++) //количество проходов в цикле в зависимости от режима
                        //ищет строку в которой более 2-х ноликов(крестиков), нет вражеских ходов и есть свободные клетки
                        if ((board.fieldToStr(mode, i, (AI ? '0': 'X'))>1) && (board.fieldToStr(mode, i,(!AI ? '0': 'X'))==0) && (board.fieldToStr(mode, i,'\u0000')>0)) {
                            int x = i;
                            int y = board.randToField(mode, i);
                            switch (mode) {
                                case 1:
                                    location[0] = y;
                                    location[1] = x;
                                    break;
                                case 2:
                                    location[0] = x;
                                    location[1] = y;
                                    break;
                                case 3:
                                    location[0] = y;
                                    location[1] = y;
                                    break;
                                case 4:
                                    location[0] = GameBoard.dimension - y - 1;
                                    location[1] = y;
                                    break;
                                default:
                                    break;
                            }

                            turn = true;
                        }

        return location;
    }
}
