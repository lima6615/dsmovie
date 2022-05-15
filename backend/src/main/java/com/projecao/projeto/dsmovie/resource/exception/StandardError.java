package com.projecao.projeto.dsmovie.resource.exception;

import java.io.Serializable;
import java.time.OffsetDateTime;

public class StandardError implements Serializable{
		private static final long serialVersionUID = 1L;

		private Integer status;
		private String error;
		private String message;
		
		private OffsetDateTime timestamp;
		
		private String path;
		
		public StandardError() {
		}

		public StandardError(Integer status, String error, String message, OffsetDateTime timestamp, String path) {
			super();
			this.status = status;
			this.error = error;
			this.message = message;
			this.timestamp = timestamp;
			this.path = path;
		}

		public Integer getStatus() {
			return status;
		}

		public void setStatus(Integer status) {
			this.status = status;
		}

		public String getError() {
			return error;
		}

		public void setError(String error) {
			this.error = error;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public OffsetDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(OffsetDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}
	}
