workflow "New workflow" {
  on = "push"
  resolves = ["gradle"]
}

action "gradle" {
  uses = "gradle"
  runs = "./gradlew clean build -x test"
}
