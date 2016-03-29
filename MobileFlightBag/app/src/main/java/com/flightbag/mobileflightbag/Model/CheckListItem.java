package com.flightbag.mobileflightbag.Model;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

/**
 * Created by casey on 2016-03-28.
 */
@Data
public class CheckListItem {

    @JsonProperty("display_name")
    private String displayName;

    @JsonProperty("checklist_file_name")
    private String checkListFileName;

    @JsonProperty("image")
    private String imageSrc;

}
