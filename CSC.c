#include <stdio.h>
#include <Windows.h>

int main() {
    HCURSOR array[15];
    array[0] = LoadCursor(NULL, IDC_APPSTARTING);
    array[1] = LoadCursor(NULL, IDC_ARROW);
    array[2] = LoadCursor(NULL, IDC_CROSS);
    array[3] = LoadCursor(NULL, IDC_HAND);
    array[4] = LoadCursor(NULL, IDC_HELP);
    array[5] = LoadCursor(NULL, IDC_IBEAM);
    array[6] = LoadCursor(NULL, IDC_ICON);
    array[7] = LoadCursor(NULL, IDC_NO);
    array[8] = LoadCursor(NULL, IDC_SIZEALL);
    array[9] = LoadCursor(NULL, IDC_SIZENESW);
    array[10] = LoadCursor(NULL, IDC_SIZENS);
    array[11] = LoadCursor(NULL, IDC_SIZENWSE);
    array[12] = LoadCursor(NULL, IDC_SIZEWE);
    array[13] = LoadCursor(NULL, IDC_UPARROW);
    array[14] = LoadCursor(NULL, IDC_WAIT);

    DWORD Array[15];

    Array[0] = 32512;
    Array[1] = 32513;
    Array[2] = 32514;
    Array[3] = 32515;
    Array[4] = 32651;
    Array[5] = 32516;
    Array[6] = 32640;
    Array[7] = 32641;
    Array[8] = 32642;
    Array[9] = 32643;
    Array[10] = 32644;
    Array[11] = 32645;
    Array[12] = 32646;
    Array[13] = 32648;
    Array[14] = 32649;

    int random = rand()%15;

    for (int i = 0; i < 15; ++i) {
        SetSystemCursor(array[i], Array[random]);
    }
    return 0;
}
