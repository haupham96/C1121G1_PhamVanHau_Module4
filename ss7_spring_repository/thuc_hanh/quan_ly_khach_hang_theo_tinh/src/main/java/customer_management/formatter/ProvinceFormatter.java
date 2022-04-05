package customer_management.formatter;

import customer_management.model.Province;
import customer_management.service.IProvinceSerice;
import customer_management.model.Province;
import customer_management.service.IProvinceSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;
import java.util.Optional;

@Component
public class ProvinceFormatter implements Formatter<Province> {

    private IProvinceSerice provinceService;

    @Autowired
    public ProvinceFormatter(IProvinceSerice provinceService) {
        this.provinceService = provinceService;
    }

    @Override
    public Province parse(String text, Locale locale) throws ParseException {
        Province provinceOptional = provinceService.findById(Long.parseLong(text));
        return provinceOptional;
    }

    @Override
    public String print(Province object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
    }
}