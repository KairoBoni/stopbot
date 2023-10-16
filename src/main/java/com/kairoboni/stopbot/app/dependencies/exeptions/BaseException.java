package com.kairoboni.stopbot.app.dependencies.exeptions;

import java.util.Date;

public record BaseException(Date timestamp, String message, String datails){}
