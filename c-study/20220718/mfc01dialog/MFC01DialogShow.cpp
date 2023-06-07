// MFC01DialogShow.cpp: 实现文件
//

#include "pch.h"
#include "mfc01dialog.h"
#include "MFC01DialogShow.h"
#include "afxdialogex.h"


// MFC01DialogShow 对话框

IMPLEMENT_DYNAMIC(MFC01DialogShow, CDialogEx)

MFC01DialogShow::MFC01DialogShow(CWnd* pParent /*=nullptr*/)
	: CDialogEx(IDD_SHOW, pParent)
{

}

MFC01DialogShow::~MFC01DialogShow()
{
}

void MFC01DialogShow::DoDataExchange(CDataExchange* pDX)
{
	CDialogEx::DoDataExchange(pDX);
}


BEGIN_MESSAGE_MAP(MFC01DialogShow, CDialogEx)
END_MESSAGE_MAP()


// MFC01DialogShow 消息处理程序
