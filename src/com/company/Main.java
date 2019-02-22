package com.company;
import java.util.*;

public class Main {
    static int[][] initial = new int[3][3];
    static int[][] goal = new int[3][3];
    static int[][] check = new int[3][3];
    static List<int[][]> list = new ArrayList<>();
    static List<Integer> previousPosition = new ArrayList<>();
    static List<Integer> moves = new ArrayList<>();
    static List<int[][]> steps = new ArrayList<>();
    public static void main(String[] args) {
        // write your code here
        int node = 0, ind = 0, space = 0, flag = 0, numOfNodes = 0;
        int[][] indexPositions = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                indexPositions[i][j] = ind++;
            }
        }
        System.out.print("Enter initial state:");
        initial = input();
        showPuzzle(initial);
        System.out.print("Enter goal state:");
        goal = input();
        showPuzzle(goal);
        list.add(initial);
        int z = 1, x = 0, a = 0, b = 0, count = 1, f;
        while (flag != 1) {
            check = list.get(node);
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (check[i][j] == 0) {
                        space = indexPositions[i][j];
                        if (a == 0) {
                            previousPosition.add(space);
                            moves.add(0);
                        }
                        break;
                    }
                }
            }
            numOfNodes += addPuzzle(space, check, previousPosition.get(node));
            while (b < numOfNodes) {
                moves.add(node);
                b++;
            }
            for (x = z; x <= numOfNodes; x++) {
                check = list.get(x);
                if (Arrays.deepEquals(check, goal)) {
                    flag = 1;
                    b = moves.get(x);
                    steps.add(list.get(x));
                    while (b != 0) {
                        f = b;
                        steps.add(list.get(f));
                        count++;
                        b = moves.get(f);
                    }
                    steps.add(list.get(0));
                    Collections.reverse(steps);
                    System.out.println("Solution steps:");
                    for (int p=0;p<steps.size();p++)
                    {
                        System.out.println("------------------");
                        showPuzzle(steps.get(p));
                    }
                    System.out.println("Node = " + x);
                    System.out.println("Moves = " + count);
                    break;
                }
            }
            z = x;
            node++;
            a = 1;
        }
    }

    static int[][] input() {
        int[][] puzzle = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                puzzle[i][j] = scanner.nextInt();
            }
        }
        return puzzle;
    }

    static void showPuzzle(int[][] puzzle) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(puzzle[i][j] + "\t");
            }
            System.out.println();
        }
    }

    static int addPuzzle(int space, int[][] check, int prePosition) {
        int nodesCreated = 0;
        switch (space) {
            case 0: {
                if (prePosition != 1) {
                    int[][] pu = change(check);
                    pu[0][0] = pu[0][1];
                    pu[0][1] = 0;
                    list.add(pu);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 3) {
                    int[][] pu = change(check);
                    pu[0][0] = pu[1][0];
                    pu[1][0] = 0;
                    list.add(pu);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                break;
            }

            case 1: {
                if (prePosition != 0) {
                    int[][] pu1 = change(check);
                    pu1[0][1] = pu1[0][0];
                    pu1[0][0] = 0;
                    list.add(pu1);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 2) {
                    int[][] pu1 = change(check);
                    pu1[0][1] = pu1[0][2];
                    pu1[0][2] = 0;
                    list.add(pu1);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 4) {
                    int[][] pu1 = change(check);
                    pu1[0][1] = pu1[1][1];
                    pu1[1][1] = 0;
                    list.add(pu1);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                break;
            }

            case 2: {
                if (prePosition != 1) {
                    int[][] pu2 = change(check);
                    pu2[0][2] = pu2[0][1];
                    pu2[0][1] = 0;
                    list.add(pu2);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 5) {
                    int[][] pu2 = change(check);
                    pu2[0][2] = pu2[1][2];
                    pu2[1][2] = 0;
                    list.add(pu2);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                break;
            }

            case 3: {
                if (prePosition != 0) {
                    int[][] pu3 = change(check);
                    pu3[1][0] = pu3[0][0];
                    pu3[0][0] = 0;
                    list.add(pu3);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 4) {
                    int[][] pu3 = change(check);
                    pu3[1][0] = pu3[1][1];
                    pu3[1][1] = 0;
                    list.add(pu3);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 6) {
                    int[][] pu3 = change(check);
                    pu3[1][0] = pu3[2][0];
                    pu3[2][0] = 0;
                    list.add(pu3);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                break;
            }

            case 4: {
                if (prePosition != 1) {
                    int[][] pu4 = change(check);
                    pu4[1][1] = pu4[0][1];
                    pu4[0][1] = 0;
                    list.add(pu4);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 3) {
                    int[][] pu4 = change(check);
                    pu4[1][1] = pu4[1][0];
                    pu4[1][0] = 0;
                    list.add(pu4);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 5) {
                    int[][] pu4 = change(check);
                    pu4[1][1] = pu4[1][2];
                    pu4[1][2] = 0;
                    list.add(pu4);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 7) {
                    int[][] pu4 = change(check);
                    pu4[1][1] = pu4[2][1];
                    pu4[2][1] = 0;
                    list.add(pu4);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                break;
            }

            case 5: {
                if (prePosition != 2) {
                    int[][] pu5 = change(check);
                    pu5[1][2] = pu5[0][2];
                    pu5[0][2] = 0;
                    list.add(pu5);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 4) {
                    int[][] pu5 = change(check);
                    pu5[1][2] = pu5[1][1];
                    pu5[1][1] = 0;
                    list.add(pu5);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 8) {
                    int[][] pu5 = change(check);
                    pu5[1][2] = pu5[2][2];
                    pu5[2][2] = 0;
                    list.add(pu5);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                break;
            }

            case 6: {
                if (prePosition != 7) {
                    int[][] pu6 = change(check);
                    pu6[2][0] = pu6[2][1];
                    pu6[2][1] = 0;
                    list.add(pu6);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 3) {
                    int[][] pu6 = change(check);
                    pu6[2][0] = pu6[1][0];
                    pu6[1][0] = 0;
                    list.add(pu6);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                break;
            }

            case 7: {
                if (prePosition != 6) {
                    int[][] pu7 = change(check);
                    pu7[2][1] = pu7[2][0];
                    pu7[2][0] = 0;
                    list.add(pu7);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 8) {
                    int[][] pu7 = change(check);
                    pu7[2][1] = pu7[2][2];
                    pu7[2][2] = 0;
                    list.add(pu7);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 4) {
                    int[][] pu7 = change(check);
                    pu7[2][1] = pu7[1][1];
                    pu7[1][1] = 0;
                    list.add(pu7);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                break;
            }

            case 8: {
                if (prePosition != 7) {
                    int[][] pu8 = change(check);
                    pu8[2][2] = pu8[2][1];
                    pu8[2][1] = 0;
                    list.add(pu8);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                if (prePosition != 5) {
                    int[][] pu8 = change(check);
                    pu8[2][2] = pu8[1][2];
                    pu8[1][2] = 0;
                    list.add(pu8);
                    previousPosition.add(space);
                    nodesCreated++;
                }
                break;
            }

            default: {
                System.out.println("Invalid position");
                break;
            }

        }
        return nodesCreated;
    }

    public static int[][] change(int[][] arr) {
        int[][] k = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                k[i][j] = arr[i][j];
            }
        }
        return k;
    }
}