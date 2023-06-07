
#include "pch.h"
#include "util.h"


HANDLE ZUtil::getProcessByName(LPCTSTR pszClassName, LPCTSTR pszWindowTitle) {
	DWORD pid;
	HWND hwnd = FindWindow(pszClassName, pszWindowTitle);
	GetWindowThreadProcessId(hwnd, &pid);
	HANDLE hProc = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pid);
	return hProc;
}

