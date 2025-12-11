class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = getMax(piles);

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canFinish(piles, h, mid)) {
                right = mid;      // tən orta
            } else {
                left = mid + 1;   // ortanı keçsin
            }
        }

        return left;
    }

    private boolean canFinish(int[] piles, int h, int speed) {
        int hours = 0;

        for (int pile : piles) {
            // ceil(pile / speed) → (pile + speed - 1) / speed
            hours += (pile + speed - 1) / speed;

            if (hours > h) return false; // artıq h saatı keçdisə, çatmır
        }

        return true;
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int pile : piles) {
            if (pile > max) max = pile;
        }
        return max;
    }
}
