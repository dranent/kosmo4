/*
 * Copyright (c) 2012 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.biz.common;

import com.biz.auth.GoogleAuth;
import com.biz.vo.YoutubeVO;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ResourceId;
import com.google.api.services.youtube.model.SearchListResponse;
import com.google.api.services.youtube.model.SearchResult;
import com.google.api.services.youtube.model.Thumbnail;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import org.springframework.stereotype.Service;


public class YoutubeSearch {

 
    private static final String PROPERTIES_FILENAME = "youtube.properties";

    private static final long NUMBER_OF_VIDEOS_RETURNED = 5;

 
    private static YouTube youtube;

    //public static void main(String[] args) {
    public ArrayList<YoutubeVO> search(String queryTerm) {
    	
    	//-----------------------------구글   API 사용자 인증 (수정 금지)--------------------------------
        Properties properties = new Properties();
        try {
            InputStream in = YoutubeSearch.class.getResourceAsStream("/" + PROPERTIES_FILENAME);
            properties.load(in);

        } catch (IOException e) {
            System.err.println("There was an error reading " + PROPERTIES_FILENAME + ": " + e.getCause()
                    + " : " + e.getMessage());
            System.exit(1);
        }
        //-------------------------------------------------------------------------------------
        
        
        ArrayList<YoutubeVO> list = new ArrayList<YoutubeVO>();
        StringBuffer buffer  = new StringBuffer();
        
        
        try {
        	//인증키를 이용한 검색 인스턴스 생성
            youtube = new YouTube.Builder(GoogleAuth.HTTP_TRANSPORT, GoogleAuth.JSON_FACTORY, new HttpRequestInitializer() {
                public void initialize(HttpRequest request) throws IOException {
                }
            }).setApplicationName("youtube-cmdline-search-sample").build();
            String apiKey = properties.getProperty("youtube.apikey");
            
            
            //----------------------------------------------
            //검색어를 이용한 유투브 동영상 파일 검색 
            //String queryTerm = getInputQuery();
            // https://developers.google.com/youtube/v3/docs/search/list#type
            //----------------------------------------------            
            YouTube.Search.List search = youtube.search().list("id,snippet");
            search.setKey(apiKey);
            search.setQ(queryTerm);
            search.setType("video");


            //검색 시 가져올 데이터 항목 설정
            search.setFields("items(id/kind,id/videoId,snippet/title,snippet/thumbnails/default/url)");
            search.setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
            
            //검색실행
            SearchListResponse searchResponse = search.execute();
            List<SearchResult> searchResultList = searchResponse.getItems();
            Iterator iteratorSearchResults = searchResultList.iterator();

            
            //----------------------검색결과 출력 -----------------------------
            if (searchResultList != null) {
                //prettyPrint(searchResultList.iterator(), queryTerm);            	
            	 System.out.println("\n=============================================================");
                 System.out.printf("검색어: %s  (%d)개",  queryTerm , NUMBER_OF_VIDEOS_RETURNED);
                 System.out.println("=============================================================\n");

                 if (!iteratorSearchResults.hasNext()) {
                     System.out.println("검색 결과가 없습니다.");
                 }

                 while (iteratorSearchResults.hasNext()) {
                     SearchResult singleVideo = (SearchResult)iteratorSearchResults.next();
                     ResourceId rId = singleVideo.getId();
                     if (rId.getKind().equals("youtube#video")) {
                    	 
                         Thumbnail thumbnail = singleVideo.getSnippet().getThumbnails().getDefault();
//                         System.out.println(" Video Id:" + rId.getVideoId());
//                         System.out.println(" Title: " + singleVideo.getSnippet().getTitle());
//                         System.out.println(" Thumbnail: " + thumbnail.getUrl());
//                         System.out.println("\n------\n");
                        
                         YoutubeVO vo = new YoutubeVO();
                         vo.setVideoId(rId.getVideoId());
                         vo.setTitle(singleVideo.getSnippet().getTitle());
                         vo.setImgurl(thumbnail.getUrl());
                         list.add(vo);
                     }
                 }            	
            }
            //--------------------검색결과 출력 -------------------------------
            
            
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            t.printStackTrace();
        }
        return list;
    }

}
