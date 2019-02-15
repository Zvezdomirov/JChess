package com.chess.gui;

import com.chess.engine.board.Board;
import com.chess.engine.board.Constants;
import com.chess.engine.game.Game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Table {
    private static final Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
    private static final Dimension BOARD_PANEL_DIMENSION =
            new Dimension(400, 350);
    private static Dimension OUTER_FRAME_DIMENSION =
            new Dimension(600, 600);
    private Board chessBoard;
    private final String DEFAULT_IMG_PATH = "art/pieces/";
    private final JFrame gameFrame;
    private final BoardPanel boardPanel;

    public Table(Board chessBoard) {
        this.chessBoard = chessBoard;
        this.gameFrame = new JFrame("JChess");
        this.gameFrame.setLayout(new BorderLayout());
        final JMenuBar tableMenuBar = new JMenuBar();
        populateMenuBar(tableMenuBar);
        this.gameFrame.setJMenuBar(tableMenuBar);
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
        this.boardPanel = new BoardPanel();
        this.gameFrame.add(boardPanel, BorderLayout.CENTER);
        this.gameFrame.setVisible(true);
    }

    private void populateMenuBar(JMenuBar tableMenuBar) {
        tableMenuBar.add(createFileMenu());
    }

    private JMenu createFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem openPGN = new JMenuItem("Load PGN File");
        openPGN.addActionListener(e -> System.out.println("This opens up the PGN file."));
        fileMenu.add(openPGN);
        final JMenuItem exitGame = new JMenuItem("Exit");
        exitGame.addActionListener(e -> System.exit(0));
        fileMenu.add(exitGame);
        return fileMenu;
    }

    private class BoardPanel extends JPanel {
        final TilePanel[][] boardTiles;

        BoardPanel() {
            super(new GridLayout(8, 8));
            this.boardTiles = new TilePanel[8][8];

            TilePanel tilePanel;
            for (int i = 0; i < Constants.ROW_SIZE; i++) {
                for (int j = 0; j < Constants.COL_SIZE; j++) {
                    tilePanel = new TilePanel(i, j);
                    boardTiles[i][j] = tilePanel;
                    add(tilePanel);
                }
            }
            setPreferredSize(BOARD_PANEL_DIMENSION);
            validate();
        }
    }

    private class TilePanel extends JPanel {
        private final int rowId;
        private final int colId;

        TilePanel(final int rowId, final int colId) {
            super(new GridBagLayout());
            this.rowId = rowId;
            this.colId = colId;
            setPreferredSize(TILE_PANEL_DIMENSION);
            assignTileColor(rowId, colId);
            assignTilePieceIcon(chessBoard);
            validate();
        }

        private void assignTilePieceIcon(final Board board) {
            this.removeAll();
            if (!board.getTile(this.rowId, this.colId).isEmpty()) {
                try {
                    String currentPath = DEFAULT_IMG_PATH + board.getTile(this.rowId, this.colId)
                            .getPieceOnTop().getPieceAlliance()
                            .toString().substring(0, 1) +
                            board.getTile(this.rowId, this.colId).getPieceOnTop()
                                    .toString() + ".gif";
                    final BufferedImage image = ImageIO.read(new File(currentPath));
                    add(new JLabel(new ImageIcon(image)));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private void assignTileColor(int rowId, int colId) {
            if ((rowId - colId) % 2 != 0) {
                setBackground(Color.darkGray);
            } else {
                setBackground(Color.WHITE);
            }
        }
    }


}
