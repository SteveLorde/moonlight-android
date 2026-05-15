package com.dawnlight.computers;

import com.dawnlight.nvstream.http.ComputerDetails;

public interface ComputerManagerListener {
    void notifyComputerUpdated(ComputerDetails details);
}
