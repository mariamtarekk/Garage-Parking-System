package com.mhk;

import java.util.Comparator;

public class SlotComparator {
    
    public static Comparator<Slot> slotComparator = new Comparator<Slot>() {
        @Override
        public int compare(Slot o1, Slot o2) {
            if( o1.getDimensions().getWidth() > o2.getDimensions().getWidth()){
                return 1;
            }
            else if(o1.getDimensions().getWidth() < o2.getDimensions().getWidth()){
                return -1;
            }
            else{
                if( o1.getDimensions().getDepth() > o2.getDimensions().getDepth()){
                    return 1;
                }
                else if(o1.getDimensions().getDepth() < o2.getDimensions().getDepth()){
                    return -1;
                }
                else{
                    return 0;
                }
            }
        }
    };
}
