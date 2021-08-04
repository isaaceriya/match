package com.fsbtech.interviews;

import com.fsbtech.interviews.entities.Event;
import com.fsbtech.interviews.entities.MarketRefType;
import com.fsbtech.interviews.entities.Clientmodel;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public class ClientFileRepository implements Client{
    private final ArrayList<Event> events = new ArrayList<>();
//    private final ArrayList<MarketRefType> marketRefTypes = new ArrayList<>();

    @Override
    public void addEvent(Event event){
        events.add(event);

    }

    @Override
    public void eventCompleted(Integer id) {
       for(int i = 0; i < events.size(); i++){
           Event event = events.get(i);
           if(event.getId().equals(id)){
               events.set(i, new Event(event.getId(), event.getName(), event.getSubCategory(), event.getMarketRefType(), true));
           }
       }
    }

    @Override
    public void attachMarketRefTypeToEvent(Integer id, MarketRefType marketRefType) {
        for(int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (event.getId().equals(id)) {
                Collection<MarketRefType> marketRefTypes = event.getMarketRefType();
                if(marketRefTypes == null){
                    marketRefTypes = new ArrayList<>();
                }
                    marketRefTypes.add(marketRefType);
                    events.set(i, new Event(event.getId(), event.getName(), event.getSubCategory(), marketRefTypes, true));
            }
        }
//        find events
//        iterate through events
//        create a new object for the event with the updates
//        remove original event and add new event


    }

    @Override
    public void removeMarketRefTypeFromEvent(Integer id, MarketRefType marketRefType) {
        for(int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (event.getId().equals(id)) {
                Collection<MarketRefType> marketRefTypes = event.getMarketRefType();
                if(marketRefTypes == null){
                    marketRefTypes = new ArrayList<>();
                }
                marketRefTypes.remove(marketRefType);
                events.set(i, new Event(event.getId(), event.getName(), event.getSubCategory(), marketRefTypes, true));
            }
        }
    }


    @Override
    public Collection<String> futureEventNamesCollection(String cat, String subcat, String marketRefName) {
        return null;
    }

    @Override
    public String dumpFullStructure() {
        return null;
    }



    public Event eventById(int id){
        for(int i = 0; i < events.size(); i++) {
            Event event = events.get(i);
            if (event.getId().equals(id)){
                return event;
            }
        }
        return null;
    }
}


