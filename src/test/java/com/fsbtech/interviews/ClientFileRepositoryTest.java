package com.fsbtech.interviews;

import com.fsbtech.interviews.entities.Category;
import com.fsbtech.interviews.entities.Event;
import com.fsbtech.interviews.entities.MarketRefType;
import com.fsbtech.interviews.entities.SubCategory;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;



public class ClientFileRepositoryTest {
//    Before each


    ClientFileRepository repository = new ClientFileRepository();
//    ArrayList<Event> events = new ArrayList<>();
//    Collection<MarketRefType> marketRefTypes = new ArrayList<>();

    @BeforeEach
    void setup(){
        Category testCategory = new Category(1,"Test");
        MarketRefType testMarketRefType = new MarketRefType(1, "Test");
        SubCategory testSubCategory = new SubCategory(1, "Test", testCategory);
        Collection<MarketRefType> marketRefTypes = new ArrayList<>();
        marketRefTypes.add(testMarketRefType);
        Event testEvent = new Event(1, "Test", testSubCategory, marketRefTypes  ,true);
        repository.addEvent(testEvent);
    }

    @Test
    public void shouldAdd(){
        Category testCategory = new Category(1,"Test");
        MarketRefType testMarketRefType = new MarketRefType(1, "Test");
        SubCategory testSubCategory = new SubCategory(1, "Test", testCategory);
        Collection<MarketRefType> marketRefTypes = new ArrayList<>();
        marketRefTypes.add(testMarketRefType);
        Event testEvent = new Event(1, "Test", testSubCategory, marketRefTypes  ,true);
        repository.addEvent(testEvent);
        Event actual = testEvent;

        Event expected = repository.eventById(testEvent.getId());
        assertEquals(actual.getId(), expected.getId());
    }

    @Test
    public void eventShouldBeCompleted(){
        Category testCategory = new Category(1,"Test");
        MarketRefType testMarketRefType = new MarketRefType(1, "Test");
        SubCategory testSubCategory = new SubCategory(1, "Test", testCategory);
        Collection<MarketRefType> marketRefTypes = new ArrayList<>();
        marketRefTypes.add(testMarketRefType);
        Event testEvent = new Event(1, "Test", testSubCategory, marketRefTypes  ,true);
        repository.eventCompleted(testEvent.getId());
        Event actual = testEvent;
        assertTrue(actual.getCompleted());
    }

    @Test
    public void attachMarketRefType(){
        Category testCategory = new Category(1,"Test");
        MarketRefType testMarketRefType = new MarketRefType(1, "Test");
        SubCategory testSubCategory = new SubCategory(1, "Test", testCategory);
        Collection<MarketRefType> marketRefTypes = new ArrayList<>();
        marketRefTypes.add(testMarketRefType);
        Event testEvent = new Event(1, "Test", testSubCategory, marketRefTypes  ,true);
        repository.attachMarketRefTypeToEvent(testEvent.getId(), testMarketRefType);
        Event actual = testEvent;
        assertEquals(marketRefTypes,actual.getMarketRefType());
    }

    @Test
    public void removeMarketRefType() {
        Category testCategory = new Category(1, "Test");
        MarketRefType testMarketRefType = new MarketRefType(1, "Test");
        SubCategory testSubCategory = new SubCategory(1, "Test", testCategory);
        Collection<MarketRefType> marketRefTypes = new ArrayList<>();
        marketRefTypes.add(testMarketRefType);
        Event testEvent = new Event(1, "Test", testSubCategory, marketRefTypes, true);
        repository.removeMarketRefTypeFromEvent(testEvent.getId(), testMarketRefType);
        Event actual = testEvent;
        assertEquals(marketRefTypes, actual.getMarketRefType());
    }

}