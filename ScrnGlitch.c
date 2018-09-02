#include <stdio.h>
#include <Windows.h>
#include <stdlib.h>

int main() {

    HMONITOR monitor = MonitorFromWindow(GetDesktopWindow(), MONITOR_DEFAULTTONEAREST);
    MONITORINFO info;
    info.cbSize = sizeof(MONITORINFO);
    GetMonitorInfo(monitor, &info);
    for(int i = 0; i < 1000; i++){
    int w = info.rcMonitor.right - info.rcMonitor.left;
    int h = info.rcMonitor.bottom - info.rcMonitor.top;
    int x1 = rand() % (w - 400);
    int y1 = rand() % (h - 400);
    int x2 = rand() % (w - 400);
    int y2 = rand() % (h - 400);
    int width = rand() % 400;
    int height = rand() % 400;
    HDC hdc = GetDC(NULL);

    BitBlt(hdc, x1, y1, width, height, hdc, x2, y2, SRCCOPY);
}
    return 0;
}
