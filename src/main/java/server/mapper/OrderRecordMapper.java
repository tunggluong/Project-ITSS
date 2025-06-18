package server.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderRecordMapper {

    Integer selectRevenueByNPreviousDay(Integer numDay);

    Integer selectRevenueByNPreviousMonth(Integer numMonth);

    Integer selectRevenueByNPreviousQuarter(Integer numQuarter);

    Integer selectRevenueByNPreviousYear(Integer numYear);
}
