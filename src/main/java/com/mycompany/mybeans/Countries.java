/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mybeans;

import java.util.Date;

/**
 *
 * @author 19par
 */
public class Countries {

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    private String Country;
    private long NewConfirmed;
    private long TotalConfirmed;
    private long NewDeaths;
    private long TotalDeaths;
    private long NewRecovered;
    private long TotalRecovered;
    private Date Date;
    private Premium Premium;

    public long getNewConfirmed() {
        return NewConfirmed;
    }

    public void setNewConfirmed(long NewConfirmed) {
        this.NewConfirmed = NewConfirmed;
    }

    public long getTotalConfirmed() {
        return TotalConfirmed;
    }

    public void setTotalConfirmed(long TotalConfirmed) {
        this.TotalConfirmed = TotalConfirmed;
    }

    public long getNewDeaths() {
        return NewDeaths;
    }

    public void setNewDeaths(long NewDeaths) {
        this.NewDeaths = NewDeaths;
    }

    public long getTotalDeaths() {
        return TotalDeaths;
    }

    public void setTotalDeaths(long TotalDeaths) {
        this.TotalDeaths = TotalDeaths;
    }

    public long getNewRecovered() {
        return NewRecovered;
    }

    public void setNewRecovered(long NewRecovered) {
        this.NewRecovered = NewRecovered;
    }

    public long getTotalRecovered() {
        return TotalRecovered;
    }

    public void setTotalRecovered(long TotalRecovered) {
        this.TotalRecovered = TotalRecovered;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date Date) {
        this.Date = Date;
    }

    public Premium getPremium() {
        return Premium;
    }

    public void setPremium(Premium Premium) {
        this.Premium = Premium;
    }

    @Override
    public String toString() {
        return getCountry();
    }

    public static Countries getCountryFromGlobal(MyCovid mc) {

        Countries global = new Countries();
        global.setCountry("Global");
        global.setNewConfirmed(mc.getGlobal().getNewConfirmed());
        global.setNewDeaths(mc.getGlobal().getNewDeaths());
        global.setNewRecovered(mc.getGlobal().getNewRecovered());
        global.setTotalConfirmed(mc.getGlobal().getTotalConfirmed());
        global.setTotalRecovered(mc.getGlobal().getTotalRecovered());
        global.setDate(mc.getGlobal().getDate());
        mc.getCountries().add(global);
        return global;
    }

}
