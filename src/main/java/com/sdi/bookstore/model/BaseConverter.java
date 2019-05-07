package com.sdi.bookstore.model;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class BaseConverter<Model extends Base, DTO extends BaseDTO> implements ConverterInterface<Model, DTO> {
    public Set<Integer> convertModelsToIDs (Set<Model> modelSet) {
        return modelSet.stream()
                .map(Base::getId)
                .collect(Collectors.toSet());
    }

    public Set<Integer> convertDTOsToIDs(Set<DTO> dtoSet) {
        return dtoSet.stream()
                .map(BaseDTO::getId)
                .collect(Collectors.toSet());
    }

    public Set<DTO> convertModelsToDtos(Collection<Model> models) {
        return models.stream()
                .map(this::ModelToDTo)
                .collect(Collectors.toSet());
    }
}
