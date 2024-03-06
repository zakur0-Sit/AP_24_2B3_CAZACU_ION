import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int[][] adjMatrix = new int[n][n];

        for (int i = 1; i < n; i++) {
            adjMatrix[0][i] = 1;
            adjMatrix[i][0] = 1;

            if (i < n - 1) {
                adjMatrix[i][i + 1] = 1;
                adjMatrix[i + 1][i] = 1;
            } else {
                adjMatrix[i][1] = 1;
                adjMatrix[1][i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(adjMatrix[i][j] + " ");
            System.out.println();
        }

        int cyclesCount = Cycles(adjMatrix);
        System.out.println("Number of cycles: " + cyclesCount);
    }

    public static int CountCycles(int[][] adjMatrix, boolean[] visited, int start, int current)
    {
        int n = adjMatrix.length;
        visited[current] = true;
        int cyclesCount = 0;

        for (int i = 0; i < n; i++)
        {
            if (adjMatrix[current][i] == 1)
                cyclesCount++;
            else if(!visited[i])
                cyclesCount += CountCycles(adjMatrix, visited, start, i);
        }

        return cyclesCount;
    }

    public static int Cycles(int[][] adjMatrix) {
        int n = adjMatrix.length;
        int cyclesCount = 0;

        for (int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            cyclesCount += CountCycles(adjMatrix, visited, i, i);
        }

        return cyclesCount;
    }
}

