package ca.jrvs.apps.twitter.example.JsonParser.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "reportDate",
        "grossProfit",
        "costOfRevenue",
        "operatingRevenue",
        "totalRevenue",
        "operatingIncome",
        "netIncome"
})
public class Financial {

    @JsonProperty("reportDate")
    private String reportDate;
    @JsonProperty("grossProfit")
    private Long grossProfit;
    @JsonProperty("costOfRevenue")
    private Long costOfRevenue;
    @JsonProperty("operatingRevenue")
    private Long operatingRevenue;
    @JsonProperty("totalRevenue")
    private Long totalRevenue;
    @JsonProperty("operatingIncome")
    private Long operatingIncome;
    @JsonProperty("netIncome")
    private Long netIncome;

    @JsonProperty("reportDate")
    public String getReportDate() {
        return reportDate;
    }

    @JsonProperty("reportDate")
    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    @JsonProperty("grossProfit")
    public Long getGrossProfit() {
        return grossProfit;
    }

    @JsonProperty("grossProfit")
    public void setGrossProfit(Long grossProfit) {
        this.grossProfit = grossProfit;
    }

    @JsonProperty("costOfRevenue")
    public Long getCostOfRevenue() {
        return costOfRevenue;
    }

    @JsonProperty("costOfRevenue")
    public void setCostOfRevenue(Long costOfRevenue) {
        this.costOfRevenue = costOfRevenue;
    }

    @JsonProperty("operatingRevenue")
    public Long getOperatingRevenue() {
        return operatingRevenue;
    }

    @JsonProperty("operatingRevenue")
    public void setOperatingRevenue(Long operatingRevenue) {
        this.operatingRevenue = operatingRevenue;
    }

    @JsonProperty("totalRevenue")
    public Long getTotalRevenue() {
        return totalRevenue;
    }

    @JsonProperty("totalRevenue")
    public void setTotalRevenue(Long totalRevenue) {
        this.totalRevenue = totalRevenue;
    }

    @JsonProperty("operatingIncome")
    public Long getOperatingIncome() {
        return operatingIncome;
    }

    @JsonProperty("operatingIncome")
    public void setOperatingIncome(Long operatingIncome) {
        this.operatingIncome = operatingIncome;
    }

    @JsonProperty("netIncome")
    public Long getNetIncome() {
        return netIncome;
    }

    @JsonProperty("netIncome")
    public void setNetIncome(Long netIncome) {
        this.netIncome = netIncome;
    }
}