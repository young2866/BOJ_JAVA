import java.util.*;

import static java.lang.Math.*;


public class Main {

    public static class SegmentTree {
        long tree[];
        int treeSize;

        public SegmentTree(int arrSize) {
            int h = (int) Math.ceil(Math.log(arrSize) / Math.log(2));
            this.treeSize = (int) Math.pow(2, h + 1);
            tree = new long[treeSize];
        }

        public long init(long[] nums, int node_idx, int start, int end) {
            if (start == end) {
                return tree[node_idx] = nums[start];
            }

            return tree[node_idx] = init(nums, node_idx * 2, start, (start + end) / 2) +
                    init(nums, node_idx * 2 + 1, (start + end) / 2 + 1, end);
        }

        public void update(int node_idx, int start, int end, int idx, long diff) {
            if(idx < start || end < idx) return;

            tree[node_idx] += diff;

            if (start != end) {
                update(node_idx * 2, start, (start + end) / 2, idx, diff);
                update(node_idx * 2 + 1, (start + end) / 2 + 1, end, idx, diff);
            }
        }

        public long sum(int node_idx, int start, int end, int left, int right) {
            if (left > end || right < start) {
                return 0;
            }

            if (left <= start && end <= right) {
                return tree[node_idx];
            }
            return sum(node_idx * 2, start, (start + end) / 2, left, right) +
                    sum(node_idx * 2 + 1, (start + end) / 2 + 1, end, left, right);
        }
    }

    static int N;
    static int M;
    static int K;
    static long[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        arr = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextLong();
        }

        SegmentTree st = new SegmentTree(N);

        st.init(arr, 1, 1, N);

        for (int i = 0; i < M + K; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            long c = sc.nextLong();

            if (a == 1) {
                st.update(1, 1, N, b, c - arr[b]);
                arr[b] = c;
            } else {
                System.out.println(st.sum(1,1, N, b, (int)c));
            }
        }


    }



}

