package model

type Request struct {
	SourceFloor      int
	DestinationFloor int
}

func NewRequest(sourceFloor int, destinationFloor int) *Request {
	return &Request{
		SourceFloor:      sourceFloor,
		DestinationFloor: destinationFloor,
	}
}
