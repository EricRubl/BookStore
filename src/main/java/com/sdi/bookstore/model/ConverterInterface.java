package com.sdi.bookstore.model;

public interface ConverterInterface<Model extends Base, DTO extends BaseDTO> {
    Model DTOToModel(DTO dto);
    DTO ModelToDTo(Model model);
}
