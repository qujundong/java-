package item14;

import java.util.Comparator;

public class ComparatorTest {
    public class PhoneNumber{
        private int first;
        private int mid;

        public int getFirst() {
            return first;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public int getMid() {
            return mid;
        }

        public void setMid(int mid) {
            this.mid = mid;
        }

        public int getLast() {
            return last;
        }

        public void setLast(int last) {
            this.last = last;
        }

        private int last;
        public PhoneNumber(int first, int mid,int last){
            this.first = first;
            this.mid = mid;
            this.last = last;
        }
    }
    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber pn)->pn.getFirst()).
                    thenComparingInt(pn->pn.getMid()).thenComparingInt(pn->pn.getLast());

}
