package com.rubix.farmersmarket.domain;

import java.io.IOException;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import javax.persistence.Embeddable;

@Embeddable
public class Deliveryfrequency {
	@JsonProperty
	@JsonSerialize(using = StringBooleanSerializer.class)
	@JsonDeserialize(using = StringBooleanDeserializer.class)
	private Boolean monthly;
	@JsonProperty
	@JsonSerialize(using = StringBooleanSerializer.class)
	@JsonDeserialize(using = StringBooleanDeserializer.class)
	private Boolean daily;
	private String custom;
	public Deliveryfrequency() {
		
	}
	public Deliveryfrequency(Boolean monthly, Boolean daily, String custom) {
		super();
		this.monthly = monthly;
		this.daily = daily;
		this.custom = custom;
	}

	public Boolean getMonthly() {
		return monthly;
	}

	public void setMonthly(Boolean monthly) {
		this.monthly = monthly;
	}

	public Boolean getDaily() {
		return daily;
	}

	public void setDaily(Boolean daily) {
		this.daily = daily;
	}

	public String getCustom() {
		return custom;
	}

	public void setCustom(String custom) {
		this.custom = custom;
	}

	public static class StringBooleanSerializer extends JsonSerializer<Boolean> {

		@Override
		public void serialize(Boolean bool, JsonGenerator generator, SerializerProvider provider)
				throws IOException, JsonProcessingException {
			generator.writeString(bool ? "Yes" : "No");
		}
	}

	public static class StringBooleanDeserializer extends JsonDeserializer<Boolean> {

		@Override
		public Boolean deserialize(JsonParser parser, DeserializationContext context)
				throws IOException, JsonProcessingException {
			return !"No".equals(parser.getText());
		}
	}
}
