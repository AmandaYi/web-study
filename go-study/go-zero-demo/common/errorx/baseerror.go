package errorx

const defaultCode = 1001

type CodeError struct {
	Code int    `json:"code"`
	Msg  string `json:"msg"`
}

func (c *CodeError) Error() string {
	return c.Msg
}

type CodeErrorResponse struct {
	Code int    `json:"code"`
	Msg  string `json:"msg"`
}

func NewCodeError(code int, msg string) error {
	return &CodeError{code, msg}
}

func NewCodeErrorResponse(msg string) error {
	return NewCodeError(defaultCode, msg)
}
func (c *CodeError) Data() *CodeErrorResponse {
	return &CodeErrorResponse{
		Code: c.Code,
		Msg:  c.Msg,
	}
}
