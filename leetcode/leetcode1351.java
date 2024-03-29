class Solution {
public static int countNegatives(int[][] grid) {

        int total = 0;
        int n = grid[0].length;

        for (int[] gr : grid) { // gr은 배열 1행,2행,3행
            //System.out.println(gr);
            int negInd = binarySearchHelper(gr, 0, n - 1);

            if (negInd != -1) {
                total += n - negInd;
            }
        }

        return total;

    }

    public static int binarySearchHelper(int[] arr, int start, int end) {
        //이진탐색으로 음수 시작되는 위치 확인하고 배열의 길이부터 음수가 시작되는 인덱스값 빼주면 개수 나옴

        int idx = -1;

        while (start <= end) {

            //{4,3,2,-1}
            int mid = (start + end) / 2;

            if (arr[mid] < 0) {

                if (idx == -1) {
                    idx = mid;

                } else {

                    idx = Math.min(idx, mid);
                }
                // idx = idx == -1 ? mid : Math.min(idx, mid);
                end = mid - 1;
            }
            if (arr[mid] >= 0) { //mid계산했는데 전부다 양수인 경우 mid를 오른쪽으로 이동해서 계산해야하기 때문에
                start = mid + 1;
            }

        }
        System.out.println(idx);
        return idx;
    }
}
