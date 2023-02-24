/**
 * 
 */
/**
 * @author marlon
 *
 */
module conversor {
	requires java.desktop;
	requires java.net.http;
	requires java.xml.crypto;
	requires java.sql;
	requires com.fasterxml.jackson.databind;
	requires com.fasterxml.jackson.core;
	requires com.fasterxml.jackson.annotation;
	exports controller;
	opens controller;
}