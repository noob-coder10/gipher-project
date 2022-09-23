package com.gipher.fetchapi.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.List;

import com.gipher.fetchapi.domain.Gif;
import com.gipher.fetchapi.service.GifService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = GifController.class)

public class FavouriteControllerTest {

    // Sending request to controller
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GifController service;
    private Gif gif;
    private List<Gif> listFavourites;

    @Before
    public void setUp() throws Exception {
        gif = new Gif("W02lJpO1pd0BpRv8YM", "volleyballworld", "Rolling Go For It GIF by Volleyball World",
                "https://media3.giphy.com/media/W02lJpO1pd0BpRv8YM/giphy.gif?cid=43a78f9fcmov7hqduoifaj9ahs9lzmvdci78l8yw49cfw99u&rid=giphy.gif&ct=g",
                "https://media3.giphy.com/media/W02lJpO1pd0BpRv8YM/giphy.gif?cid=43a78f9fcmov7hqduoifaj9ahs9lzmvdci78l8yw49cfw99u&rid=giphy.gif&ct=g",
                0);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testSearchGifsByIdSuccess() throws Exception {
        when(service.searchGifsById(Mockito.anyString())).thenReturn((ResponseEntity<List<Gif>>) listFavourites);
        mockMvc.perform(get("/ball")).andExpect(status().isOk())
                .andDo(print());
        verify(service, times(1)).searchGifsById(Mockito.anyString());
    }
}