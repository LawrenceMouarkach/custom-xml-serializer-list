    private static final class ChildrenSerializer extends JsonSerializer<List<Integer>> {

        @Override
        public void serialize(List<Integer> integers, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException, JsonProcessingException {
            if (!integers.isEmpty()) {
                jsonGenerator.writeStartObject();
                for (Integer integer : integers) {
                    jsonGenerator.writeObjectField("age" + Integer.toString(integers.indexOf(integer) + 1), integer);
                }
                jsonGenerator.writeEndObject();
            } else {
                serializerProvider.defaultSerializeValue(integers, jsonGenerator);
            }
        }
    }
