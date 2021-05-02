class Solution {
   static public int[] intersect(int[] nums1, int[] nums2) {

        int[] answer;
        ArrayList<Integer> arr = new ArrayList<>();
        HashMap<Integer, Integer> hs = new HashMap<>();
        int temp = 0;
        int yes = 0;

        if (nums1.length > nums2.length) {
            temp = nums1.length;
        } else if (nums2.length >= nums1.length) {
            temp = nums2.length;
            yes = 1;
        }

        for (int i = 0; i < temp; i++) {
            if (yes == 0) {
                if (hs.containsKey(nums1[i])) {
                    int cnt = hs.get(nums1[i]);
                    cnt++;
                    hs.put(nums1[i], cnt);
                } else {
                    hs.put(nums1[i], 1);
                }
            } else {
                if (hs.containsKey(nums2[i])) {
                    int cnt = hs.get(nums2[i]);
                    cnt++;
                    hs.put(nums2[i], cnt);
                } else {
                    hs.put(nums2[i], 1);
                }
            }
        }
        
       int temp1 = 0;
        int no = 0;
        if (nums1.length <= nums2.length) {
            temp1 = nums1.length;
        } else if (nums2.length < nums1.length) {
            temp1 = nums2.length;
            no = 1;
        }

        for (int j = 0; j < temp1; j++) {
            if (no == 1) {
                if (hs.get(nums2[j]) != null &&hs.get(nums2[j])!=0) {
                    int cnt = hs.get(nums2[j]);
                    arr.add(nums2[j]);
                    cnt--;
                    hs.put(nums2[j], cnt);
                } else {
                    continue;
                }
            } else {
               if (hs.get(nums1[j]) != null&&hs.get(nums1[j])>0) {
                    int cnt = hs.get(nums1[j]);
                    arr.add(nums1[j]);
                    cnt--;
                    hs.put(nums1[j], cnt);
                } else {
                    continue;
                }
            }

        }
        answer = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            answer[i] = arr.get(i);
            System.out.println(answer[i]);
        }

        return answer;

    }
}
