#pragma once
#include <windows.h>
class ZUtil {
public:
	HANDLE getProcessByName(LPCTSTR pszClassName, LPCTSTR pszWindowTitle);
};