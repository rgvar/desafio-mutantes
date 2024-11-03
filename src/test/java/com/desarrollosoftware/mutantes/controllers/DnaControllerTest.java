package com.desarrollosoftware.mutantes.controllers;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
    class DnaControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @Order(2)
    public void emptyArrayRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(3)
    public void nxmArrayRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                 "  \"dna\": [\n" +
                                 "      \"TCTCAT\",\n" +
                                 "      \"AGTCGA\",\n" +
                                 "      \"TATGCA\",\n" +
                                 "      \"ACGTGT\",\n" +
                                 "      \"GCTACT\"\n" +
                                 "      ]\n" +
                                 "}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(4)
    public void numberArrayRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"dna\": [\n" +
                                "      \"3465\",\n" +
                                "      \"8656\",\n" +
                                "      \"8142\",\n" +
                                "      \"9862\"\n" +
                                "      ]\n" +
                                "}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(5)
    public void nullRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("null"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(6)
    public void nullArrayRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "  \"dna\": [\n" +
                        "      \"null\",\n" +
                        "      \"null\",\n" +
                        "      \"null\",\n" +
                        "      \"null\"\n" +
                        "      ]\n" +
                        "}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(7)
    public void otherLettersArrayRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "  \"dna\": [\n" +
                                "    \"GCAC\",\n" +
                                "    \"TGAC\",\n" +
                                "    \"TCRA\",\n" +
                                "    \"AGCT\"\n" +
                                "  ]\n" +
                                "}"))
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(8)
    public void mutantDnaRequest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"dna\": [\n" +
                        "        \"AAAAC\",\n" +
                        "        \"GTGAT\",\n" +
                        "        \"TGTCA\",\n" +
                        "        \"ATACA\",\n" +
                        "        \"GGGGT\"\n" +
                        "    ]\n" +
                        "}"))
                .andExpect(status().isOk());
    }

    @Test
    @Order(9)
    public void notMutantDnaRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\n" +
                        "    \"dna\": [\n" +
                        "        \"CGAGA\",\n" +
                        "        \"TCACA\",\n" +
                        "        \"GTGAC\",\n" +
                        "        \"CGTCT\",\n" +
                        "        \"TATGC\"\n" +
                        "    ]\n" +
                        "}"))
                .andExpect(status().isForbidden());
    }


    @Test
    @Order(10)
    public void mutantDnaRequestBig() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"dna\": [\n" +
                                "        \"TCGGGTGAT\",\n" +
                                "        \"TGATCCTTT\",\n" +
                                "        \"TACGAGTGA\",\n" +
                                "        \"AAATGTACG\",\n" +
                                "        \"ACGAGTGCT\",\n" +
                                "        \"AGACACATG\",\n" +
                                "        \"GAATTCCAA\",\n" +
                                "        \"ACTACGACC\",\n" +
                                "        \"TGAGTATCC\"\n" +
                                "    ]\n" +
                                "}\n"))
                .andExpect(status().isOk());
    }


}