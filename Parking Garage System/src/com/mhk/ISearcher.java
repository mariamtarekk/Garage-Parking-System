package com.mhk;

import java.util.Vector;

public interface ISearcher {
    public int searchForAvailableSlot(Vehicle v, Vector<Slot> slots);
}
