package org.fundacion.common.api;

import io.restassured.path.json.JsonPath;
import java.io.IOException;
import java.util.List;
import org.testng.annotations.Test;


/**
 * Created by RoyRodriguez on 12/23/2016.
 */
public class Tests {

  @Test
  public void testGetAllProjects() throws IOException {
    RestAssured restAssured = new RestAssured();

    JsonPath res = restAssured.get("projects");
    System.out.println(res.getList("id").get(0).getClass());

    ApiProjects projects = new ApiProjects();
    List<Project> projectList = projects.getAllProjectsNames();

    for (Project project : projectList) {
      System.out.println(project.getName());
    }

  }

  @Test
  public void getProject() throws IOException {
    ApiProjects projects = new ApiProjects();
    Project project = projects.getProjectByName("asdf");
    System.out.println(project.getId());
  }

  @Test
  public void testDelete() throws IOException {
    ApiProjects projects = new ApiProjects();
    System.out.println(projects.deleteProjectByName("asdf"));
  }

  @Test
  public void testDeleteAllProjects() throws IOException {
    ApiProjects projects = new ApiProjects();
    System.out.println(projects.deleteAllProjects());
  }


  @Test
  public void getAllWorkspaces() throws IOException {
    ApiWorkspaces workspaces = new ApiWorkspaces();
    List<Workspace> list = workspaces.getAllWorkSpaces();

    for (Workspace workspace: list) {
      System.out.println(workspace.getName());
    }
  }

  @Test
  public void getWorkspace() throws IOException {
    ApiWorkspaces workspaces = new ApiWorkspaces();
    Workspace workspace = workspaces.getWorkspaceByName("asdf");
    System.out.println(workspace.getId());
  }

  @Test
  public void deleteWorkspace() throws IOException {
    ApiWorkspaces workspaces = new ApiWorkspaces();
    System.out.println(workspaces.deleteWorkspaceByName("asdf"));
  }

  @Test
  public void deleteAllWorkspaces() throws IOException {
    ApiWorkspaces workspaces = new ApiWorkspaces();
    System.out.println(workspaces.deleteAllWorkspaces());
  }
}