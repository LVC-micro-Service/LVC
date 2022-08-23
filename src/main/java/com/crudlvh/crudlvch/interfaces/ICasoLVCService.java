package com.crudlvh.crudlvch.interfaces;

import com.crudlvh.crudlvch.dto.CasoLVCDTO;
import com.crudlvh.crudlvch.entities.CasoLVC;

public interface ICasoLVCService{

    CasoLVC registrarCaso(CasoLVCDTO dto);
}