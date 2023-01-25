package com.ayi.serv.app.services;

import com.ayi.serv.app.dto.response.WineResponseDTO;
import com.ayi.serv.app.exceptions.DataBaseException;
import com.ayi.serv.app.exceptions.ReadAccessException;
//import com.ayi.serv.app.exceptions.DataBaseException;
//import com.ayi.serv.app.exceptions.ReadAccessException;

import java.util.List;

public interface IWineService {
    List<WineResponseDTO> getAllWines() throws ReadAccessException, DataBaseException;// throws ReadAccessException, DataBaseException;
}
