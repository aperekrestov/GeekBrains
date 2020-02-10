package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameBoard extends JFrame {
    static int dimension = 3;
    static int cellSize = 150;
    private char[][] gameField;
    private GameButton[] gameButtons;

    private Game game;

    static char nullSymbol = '\u0000';

    public GameBoard(Game currantGame) {
        this.game = currantGame;
        initField();
    }
    /**
     * преобразование строки матрицы в текстовую строку и подсчет количества Х и 0 в ней
     * @param mode принимает значения 1-по вертикали 2-по горизонтали 3-диагональ 4-обратная диагональ
     * @param num номер строки или ряда
     * @param sym символ Х или 0 для подсчета
     * @return  количество искомых символов
     */
    public int fieldToStr(int mode, int num, char sym){
        int result = 0;
        String str;
        char[] dop = new char[dimension];
        //собираем символы из матрици в зависимости от режима обхода
        for (int i = 0; i < dimension; i++)
            switch (mode){
                case 1: dop[i] = gameField[i][num]; break;
                case 2: dop[i] = gameField[num][i]; break;
                case 3: dop[i] = gameField[i][i];   break;
                case 4: dop[i] = gameField[dimension-i-1][i]; break;
                default: break;
            }


        str = new String(dop);
        // считаем количество искомых символов
        result = str.length() - str.replace(Character.toString(sym), "").length();
        return result;
    }

    private void initField() {
        // настройки окна
        setBounds(cellSize * dimension, cellSize * dimension, 400, 300);
        setTitle("Крестики-нолики");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel controlPanel = new JPanel();
        JButton newGameButton = new JButton("Новая игра");
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                emptyField();
            }
        });

        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.add(newGameButton);
        controlPanel.setSize(cellSize * dimension, 150);

        // панель игры
        JPanel gameFieldPanel = new JPanel();
        gameFieldPanel.setLayout(new GridLayout(dimension, dimension));
        gameFieldPanel.setSize(cellSize, dimension * dimension);

        gameField = new char[dimension][dimension];
        gameButtons = new GameButton[dimension * dimension];

        for (int i = 0; i < (dimension * dimension); i++) {
            GameButton fieldButton = new GameButton(i, this);
            gameFieldPanel.add(fieldButton);
            gameButtons[i] = fieldButton;
        }

        getContentPane().add(controlPanel, BorderLayout.NORTH);
        getContentPane().add(gameFieldPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    // метод очистки поля и матрицы игры
    void emptyField() {
        for (int i = 0; i < (dimension * dimension); i++){
            gameButtons[i].setText("");

            int x = i / GameBoard.dimension;
            int y = i % GameBoard.dimension;

            gameField[x][y] = nullSymbol;

            //todo решить проблему с переключением символа при выигрыше Ai
        }
    }

    Game getGame() {
        return game;
    }

    // метод проверки доступности хода
    boolean isTurnable(int x, int y){
        boolean result = false;

        if (gameField[y][x] == nullSymbol){
            result = true;
        }

        return result;
    }


    // обновление матрицы игры
    void updateGameField(int x, int y) {
        gameField[y][x] = game.getCurrentPlayer().getPlayerSign();
    }

    // проверка победы
    boolean checkWin() {
        boolean result = false;
        char playerSymbol = getGame().getCurrentPlayer().getPlayerSign();

        if (checkWinDiagonals(playerSymbol) || checkWinLines(playerSymbol)) {
            result = true;
        }

        return result;
    }

    boolean isFull() {
        boolean result = true;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (gameField[i][j] == nullSymbol);
                result = false;
            }

        }

        return result;
    }

    public GameButton getButton(int buttonIndex) {
        return gameButtons[buttonIndex];
    }

    private boolean checkWinDiagonals(char playerSymbol){
        boolean leftRight, rightLeft, result;

        leftRight = true;
        rightLeft = true;
        result = false;

        for(int i = 0; i < dimension; i++){
            leftRight &= (gameField[i][i] == playerSymbol); //оптимизация кода, чтобы не было через if/else
            rightLeft &= (gameField[dimension - i - 1][i] == playerSymbol);
        }

        if(leftRight || rightLeft){
            result = true;
        }

        return result;

    }

    private boolean checkWinLines(char playerSymbol){
        boolean cols, rows, result;

        result = false;

        for(int col = 0; col < dimension; col++){
            cols = true;
            rows = true;

            for(int row = 0; row < dimension; row++){
                cols &= (gameField[col][row] == playerSymbol);
                rows &= (gameField[row][col] == playerSymbol);
            }
            if(cols || rows){
                result = true;
                break;
            }
            if(result) {
                break;
            }
        }
        return result;
    }

    /**
     * находит в заданной строке(столбце или диагонали) случайную свободную клетку для установки "0"
     * @param mode принимает значения 1-по вертикали 2-по горизонтали 3-диагональ 4-обратная диагональ
     * @param num номер строки или ряда
     * @return  координата свободной клетки в строке(столбце или диагонали)
     */
    public int randToField(int mode, int num){
        int x=-1;
        Random rnd = new Random();
        boolean result = false;
        do {
            // генерация случайного значения
            x = rnd.nextInt(GameBoard.dimension);
            //прооверка клетки на занятость в зависимости от режима обхода
            switch (mode){
                case 1: result = isTurnable(x, num); break;
                case 2: result = isTurnable(num, x); break;
                case 3: result = isTurnable(x, x);   break;
                case 4: result = isTurnable(dimension-x-1, x); break;
                default: break;
            }

        } while (!result);
        return x;
    }
}
