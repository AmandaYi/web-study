// MFC01DialogExec.cpp: 实现文件
//

#include "pch.h"
#include "mfc01dialog.h"
#include "MFC01DialogExec.h"
#include "afxdialogex.h"


// MFC01DialogExec 对话框

IMPLEMENT_DYNAMIC(MFC01DialogExec, CDialogEx)

MFC01DialogExec::MFC01DialogExec(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_EXEC, pParent)
{

}

MFC01DialogExec::~MFC01DialogExec()
{
}

void MFC01DialogExec::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}


BEGIN_MESSAGE_MAP(MFC01DialogExec, CDialogEx)
END_MESSAGE_MAP()


// MFC01DialogExec 消息处理程序
