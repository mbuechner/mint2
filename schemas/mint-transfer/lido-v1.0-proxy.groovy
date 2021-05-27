top = new JSONMappingHandler(mapping)
template = top.getTemplate()

lido = template.getHandlersForPath("/lido:lido");
lido.setString(JSONMappingHandler.ELEMENT_MINOCCURS, "1");

schemaId = template.getHandlersForPath("/lido:lido/lido:lidoRecID").get(0);
//schemaId.addConstantMapping("/" + Config.get("mint.title") + ":000000");
schemaId.setMandatory(true)
//schemaId.setString(JSONMappingHandler.ELEMENT_MINOCCURS, "1");
schemaId.setFixed(true);
schemaIdType = schemaId.getAttribute("@lido:type");
schemaIdType.addConstantMapping("local");
schemaIdType.setMandatory(true);
//schemaIdType.setString(JSONMappingHandler.ELEMENT_MINOCCURS, "1");
schemaIdType.setFixed(true);
// create europeana classification
objectWorkType = template.getHandlersForPath("/lido/descriptiveMetadata/objectClassificationWrap/objectWorkTypeWrap/objectWorkType").get(0);
//europeanaClassification.setLabel("classification (europeana)");
//europeanaType = europeanaClassification.getAttribute("@lido:type");
//europeanaType.addConstantMapping("europeana:type");
//europeanaTerm = europeanaClassification.getChild("lido:term")
//europeanaTerm.addEnumeration("IMAGE");
//europeanaTerm.addEnumeration("SOUND");
//europeanaTerm.addEnumeration("TEXT");
//europeanaTerm.addEnumeration("VIDEO");
//europeanaTerm.addEnumeration("3D");
objectWorkType.setMandatory(true);
objectWorkType.setFixed(true);

title = template.getHandlersForPath("/lido/descriptiveMetadata/objectIdentificationWrap/titleWrap/titleSet/appellationValue").get(0);
// europeana record source
//recordInfoLink =  template.getHandlersForName("recordInfoSet").get(0).getHandlersForName("recordInfoLink").get(0);
title.setMandatory(true);

recordID = template.getHandlersForPath("/lido/administrativeMetadata/recordWrap/recordID");
recordID.setMandatory(true);
//originalRecordSource = template.getHandlersForName("recordSource").get(0);
recordSource = template.getHandlersForPath("/lido/administrativeMetadata/recordWrap/recordSource").get(0);
recordSource.setMandatory(true);
recordType = template.getHandlersForPath("/lido/administrativeMetadata/recordWrap/recordType");
recordType.setMandatory(true);
//recordSourceType = recordSource.getAttribute("@lido:type");
//recordSourceType.addConstantMapping("europeana:dataProvider");
//recordSourceType.setFixed(true);
//recordSourceAppellation = recordSource.getChild("lido:legalBodyName");
//recordSourceAppellation.setMandatory(true);
//originalRecordSource.setString(JSONMappingHandler.ELEMENT_MINOCCURS, "0");

// create master & thumb resource, resource rights
//resource = template.duplicatePath("/lido/administrativeMetadata/resourceWrap/resourceSet");
//resource.setLabel("resourceSet (europeana)");

//master = template.duplicatePath("/lido/administrativeMetadata/resourceWrap/resourceSet/resourceRepresentation");
//master.setLabel("resourceRepresentation (master)");
//master.setRemovable(true);

//thumb = template.duplicatePath("/lido/administrativeMetadata/resourceWrap/resourceSet/resourceRepresentation");
//thumb.setLabel("resourceRepresentation (thumb)");
//thumb.setRemovable(true);
//rights = resource.getChild("lido:rightsResource");
//rights.setLabel("rightsResource (europeana)");
//rights.setMandatory(true);

//linkResource = master.getChild("lido:linkResource");
//linkResource.setLabel("linkResource (master)");
//linkType = master.getAttribute("@lido:type");
//linkType.addConstantMapping("image_master");
//linkType.setFixed(true);

//linkResource = thumb.getChild("lido:linkResource");
//linkResource.setLabel("linkResource (thumb)");
//linkType = thumb.getAttribute("@lido:type");
//linkType.addConstantMapping("image_thumb");
//linkType.setFixed(true);

//rightsType = rights.getChild("lido:rightsType");
//rightsType.setLabel("rightsType (europeana)");
//rightsType = rightsType.getChild("lido:term");
//rightsType.setLabel("term (europeana)");
//rightsType.setMandatory(true);
//rightsType.addEnumeration("http://www.europeana.eu/rights/rr-f/");
//rightsType.addEnumeration("http://www.europeana.eu/rights/rr-p/");
//rightsType.addEnumeration("http://www.europeana.eu/rights/rr-r/");
//rightsType.addEnumeration("http://www.europeana.eu/rights/unknown/");
//rightsType.addEnumeration("http://creativecommons.org/publicdomain/mark/1.0/");
//rightsType.addEnumeration("http://creativecommons.org/publicdomain/zero/1.0/");
//rightsType.addEnumeration("http://creativecommons.org/licenses/by/3.0/");
//rightsType.addEnumeration("http://creativecommons.org/licenses/by-sa/3.0/");
//rightsType.addEnumeration("http://creativecommons.org/licenses/by-nc/3.0/");
//rightsType.addEnumeration("http://creativecommons.org/licenses/by-nc-sa/3.0/");
//rightsType.addEnumeration("http://creativecommons.org/licenses/by-nd/3.0/");
//rightsType.addEnumeration("http://creativecommons.org/licenses/by-nc-nd/3.0/");

// rights work set
//recordRights = template.duplicatePath("/lido/administrativeMetadata/recordWrap/recordRights");
//recordRights.setLabel("recordRights (europeana)");
//rightsType = recordRights.getChild("lido:rightsType").getChild("lido:term");
//rightsType.addEnumeration("CC0");
//rightsType.addEnumeration("CC0 (no descriptions)");
//rightsType.addEnumeration("CC0 (mandatory only)");
