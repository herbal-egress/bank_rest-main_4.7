package com.example.bankcards.util; 
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import lombok.extern.slf4j.Slf4j;
import java.sql.Date;
import java.time.YearMonth;
@Converter(autoApply = true)
@Slf4j
public class YearMonthAttributeConverter implements AttributeConverter<YearMonth, Date> {
    @Override
    public Date convertToDatabaseColumn(YearMonth yearMonth) {
        if (yearMonth != null) {
            return Date.valueOf(yearMonth.atDay(1));
        }
        else {
            log.warn("YearMonth равен null, возвращается null Date");
        }
        return null;
    }
    @Override
    public YearMonth convertToEntityAttribute(Date date) {
        if (date != null) {
            return YearMonth.from(date.toLocalDate());
        }
        else {
            log.warn("Date равен null, возвращается null YearMonth");
        }
        return null;
    }
}