#include <Windows.h>
#include <stdio.h>

int main(){
    for(int i = 0; i < 1000000; i ++){
    HDC hdc = GetDC(NULL);
    POINT point;
    GetCursorPos(&point);
    int ix = GetSystemMetrics(SM_CXICON) / 2;
    int iy = GetSystemMetrics(SM_CYICON) / 2;

    DrawIcon(hdc, point.x - ix, point.y - iy, LoadIcon(NULL, IDI_ERROR));
    }
}