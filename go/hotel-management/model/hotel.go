package model

import errors "hotel-management/error"

type Hotel struct {
	Address    string `json:"address"`
	TotalRooms int    `json:"total_rooms"`
	Rooms      map[int]*Room
}

func (h *Hotel) GetAvailableRoom(numOfGuests int, roomType string) (r *Room, err error) {
	for _, room := range h.Rooms {
		if !room.IsOccupied && room.NumOfBeds == numOfGuests {
			return room, nil
		}
	}

	return nil, errors.ErrNoRoomFound
}
