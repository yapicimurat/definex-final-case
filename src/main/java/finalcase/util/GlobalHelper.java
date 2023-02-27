package finalcase.util;

import org.modelmapper.ModelMapper;
import java.util.List;
import java.util.stream.Collectors;

public final class GlobalHelper {
    private GlobalHelper(){}
    public static <S, T> List<T> listDtoConverter(ModelMapper modelMapper, List<S> source, Class<T> target){
        return source.stream()
                .map(sourceElement -> modelMapper.map(sourceElement, target))
                .collect(Collectors.toList());
    }
}
