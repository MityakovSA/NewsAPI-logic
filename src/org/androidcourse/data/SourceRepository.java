package org.androidcourse.data;

import java.util.ArrayList;
import java.util.Scanner;

public class SourceRepository {
    private static Scanner in;

    public static ArrayList<SourceDTO> makeArray() {
        in = new Scanner(System.in);
        ArrayList<SourceDTO> dtoArray = new ArrayList<>();
        System.out.print("Enter \"next\" to add " +
                "dto object or \"stop\" to exit.\nEnter command: ");
        do {
            String com = in.nextLine();
            switch (com) {
                case "next":
                    SourceDTO dto = getDTO();
                    dtoArray.add(dto);
                    System.out.print("Next dto object or stop?\nEnter command: ");
                    break;
                case "stop":
                    in.close();
                    return dtoArray;
                default:
                    System.out.print("Invalid command! Enter \"next\" to add " +
                            "another dto object or \"stop\" to exit.\nEnter command: ");
            }
        } while (true);
    }

    private static SourceDTO getDTO() {
        SourceDTO dto = new SourceDTO();
        System.out.print("Enter source id: ");
        String buf = in.nextLine();
        dto.setSid(buf);
        System.out.print("Enter source name: ");
        buf = in.nextLine();
        dto.setSname(buf);
        System.out.print("Enter author: ");
        buf = in.nextLine();
        dto.setAuthor(buf);
        System.out.print("Enter title: ");
        buf = in.nextLine();
        dto.setTitle(buf);
        System.out.print("Enter description: ");
        buf = in.nextLine();
        dto.setDescr(buf);
        System.out.print("Enter URL: ");
        buf = in.nextLine();
        dto.setUrl(buf);
        System.out.print("Enter URL to image: ");
        buf = in.nextLine();
        dto.setUrlToImg(buf);
        System.out.print("Enter publication date and time: ");
        buf = in.nextLine();
        dto.setPubAt(buf);
        System.out.print("Enter content: ");
        buf = in.nextLine();
        dto.setContent(buf);
        return dto;
    }
}
