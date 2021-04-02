package com.poc.learnvertex.communs;

public class HttpStatusCode {

  //1xx: Informational
  public final static int CONTINUE= 100;
  public final static int SWITCHING_PROTOCOLS= 101;
  public final static int PROCESSING= 102;
  public final static int EARLY_HINTS= 103;

  //2xx: Success
  public final static int OK= 200;
  public final static int CREATED= 201;
  public final static int ACCEPTED= 202;
  public final static int NON_AUTHORITATIVE_INFORMATION= 203;
  public final static int NO_CONTENT= 204;
  public final static int RESET_CONTENT= 205;
  public final static int PARTIAL_CONTENT= 206;
  public final static int MULTI_STATUS= 207;
  public final static int ALREADY_REPORTED= 208;
  public final static int IM_USED= 226;

  //3xx: Redirection
  public final static int MULTIPLE_CHOICES= 300;
  public final static int MOVED_PERMANENTLY= 301;
  public final static int FOUND= 302;
  public final static int SEE_OTHER= 303;
  public final static int NOT_MODIFIED= 304;
  public final static int USE_PROXY= 305;
  public final static int TEMPORARY_REDIRECT= 307;
  public final static int PERMANENT_REDIRECT= 308;

  //4xx: Client Error
  public final static int BAD_REQUEST= 400;
  public final static int UNAUTHORIZED= 401;
  public final static int PAYMENT_REQUIRED= 402;
  public final static int FORBIDDEN= 403;
  public final static int NOT_FOUND= 404;
  public final static int METHOD_NOT_ALLOWED= 405;
  public final static int NOT_ACCEPTABLE= 406;
  public final static int PROXY_AUTHENTICATION_REQUIRED= 407;
  public final static int REQUEST_TIMEOUT= 408;
  public final static int CONFLICT= 409;
  public final static int GONE= 410;
  public final static int LENGTH_REQUIRED= 411;
  public final static int PRECONDITION_FAILED= 412;
  public final static int REQUEST_TOO_LONG= 413;
  public final static int REQUEST_URI_TOO_LONG= 414;
  public final static int UNSUPPORTED_MEDIA_TYPE= 415;
  public final static int REQUESTED_RANGE_NOT_SATISFIABLE= 416;
  public final static int EXPECTATION_FAILED= 417;
  public final static int MISDIRECTED_REQUEST= 421;
  public final static int UNPROCESSABLE_ENTITY= 422;
  public final static int LOCKED= 423;
  public final static int FAILED_DEPENDENCY= 424;
  public final static int TOO_EARLY= 425;
  public final static int UPGRADE_REQUIRED= 426;
  public final static int PRECONDITION_REQUIRED= 428;
  public final static int TOO_MANY_REQUESTS= 429;
  public final static int REQUEST_HEADER_FIELDS_TOO_LARGE= 431;
  public final static int UNAVAILABLE_FOR_LEGAL_REASONS= 451;


  public final static int INTERNAL_SERVER_ERROR= 500;

}
