package com.desarrollosoftware.mutantes.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DnaControllerTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void emptyArrayRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{}"))
                .andExpect(status().isBadRequest());
    }

    @Test
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
    public void nullRequest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/mutant")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("null"))
                .andExpect(status().isBadRequest());
    }

    @Test
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