//
// Created by Larry on 8/17/2018.
// Finalized
//

#include <Windows.h>
#include <stdio.h>

int main(){
    for (int i = 0; i < 20; ++i) {
        GetDC(NULL);
        HMONITOR monitor = MonitorFromWindow(GetDesktopWindow(), MONITOR_DEFAULTTONEAREST);
        MONITORINFO info;
        info.cbSize = sizeof(MONITORINFO);
        GetMonitorInfo(monitor, &info);
        int w = info.rcMonitor.right - info.rcMonitor.left;
        int h = info.rcMonitor.bottom - info.rcMonitor.top;
        HDC hdc = GetDC(NULL);
        StretchBlt(hdc, 50, 50, w - 100, h - 100, hdc, 0, 0, w, h, SRCCOPY);
    }
    return 0;
}