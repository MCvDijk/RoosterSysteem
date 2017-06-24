/*
private class data {
    public String roosterOpslaan(String jsonBody) {
        JsonObject lJsonObjectIn = (JsonObject) Json.createReader(new ByteArrayInputStream(jsonBody.getBytes())).read();
        String naam = lJsonObjectIn.getString("naam");
        JsonArray data = lJsonObjectIn.getJsonArray("rooster");
        String[] parts = naam.split(" ", 2);
        String voornaam = parts[0];
        String achternaam = parts[1];
        Medewerker medewerker = mservice.getMedewerker(voornaam, achternaam);
        List<MRooster> rooster = service.getMedewerkerRooster(medewerker);


        for (int i = 0; i < data.size(); i++) {
            JsonObject data_jsonobject = data.getJsonObject(i);
            System.out.println(data_jsonobject);
            if (data_jsonobject.containsKey("begintijd")
                    && data_jsonobject.containsKey("eindtijd")) {
                String dag = data_jsonobject.getString("dag");
                String weeknummer = data_jsonobject.getString("weeknr");
                String begintijd = data_jsonobject.getString("begintijd");
                String pauze = "00:30";
                String eindtijd = data_jsonobject.getString("eindtijd");

                if (!begintijd.equals("") || !eindtijd.equals("")) {
                    if (service.getMedewerkerRooster(medewerker).size() == 0) {
                        MRooster mRooster = new MRooster(
                                medewerker, weeknummer, dag, LocalTime.parse(begintijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(eindtijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(pauze + ":00"), false, medewerker.getVoornaam(), medewerker.getAchternaam(), false);
                        service.writeMRooster(mRooster);
                    } else {
                        for (MRooster mr : service.getMedewerkerRooster(medewerker)) {
                            if (mr.getWeekNummer().equals(weeknummer)
                                    && mr.getDag().equals(dag)) {

                                MRooster mRooster = new MRooster(
                                        medewerker, weeknummer, dag, LocalTime.parse(begintijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(eindtijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(pauze + ":00"), false, medewerker.getVoornaam(), medewerker.getAchternaam(), false);
                                service.updateMRooster(mRooster);
                            } else {
                                MRooster mRooster = new MRooster(
                                        medewerker, weeknummer, dag, LocalTime.parse(begintijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(eindtijd.replaceAll("\\s", "") + ":00"), LocalTime.parse(pauze + ":00"), false, medewerker.getVoornaam(), medewerker.getAchternaam(), false);
                                service.writeMRooster(mRooster);
                            }
                        }

                    }

                } else {
                    for (MRooster mr : service.getMedewerkerRooster(medewerker)) {
                        if (mr.getWeekNummer().equals(weeknummer)
                                && mr.getDag().equals(dag)) {

                            service.deleteMRooster(mr);
                        }


                    }

                }
            }
        }
        JsonObjectBuilder lJob = Json.createObjectBuilder();
        lJob.add("errorcode", 0);
        // nothing to return use only errorcode to signal: ready!
        String lJsonOutStr = lJob.build().toString();
        return lJsonOutStr; // terug naar de Polymer-GUI!
    }
}*/
