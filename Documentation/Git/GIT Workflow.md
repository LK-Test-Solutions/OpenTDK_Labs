# GIT workflow

## Mainline (Master/Main)
_A single, shared, branch that acts as the current state of the product. The mainline is a special codeline that we consider to represent the current release_

## Integration Branch
_Developers integrate their work by pulling from Integration, merging, and - if healthy - pushing back into Integration_

The integration branch is a special codeline that we consider to be the current state of the team's code. It is a central repository - a shared repository that acts as the single point of record for the project and is the origin for most clones.

Starting a new piece of work from scratch means cloning that central repository. If a clone already exists, we begin by pulling master from the central repository, so it's up to date with the integration codeline.

When working on a feature, an own personal development branch which may be the local master, or a separate local branch is created. When working on this for a while, we can keep up to date with changes in the integration codeline by pulling integration's changes at intervals and merging them into the personal development branch.

On each commit, perform automated checks, usually building and running tests, to ensure there are no defects on the branch.

Workflow:
* (2) Clone (or fetch) from Integration
* Checkout private master
* Work on own codeline on local master branch
* When point is reached to integrate
    * (3) Pull/Fetch the current state of mainline into local master branch
    * Merge or Rebase
    * Build code and run tests
* (5) Push changes to Integration ( <mark> integration is always a Pull/Fetch and a Push ! </mark> )

``` mermaid
sequenceDiagram
    autonumber
    Master/Main-->>Integration: Clone ...
    Integration-->>Private Master: Clone ...
    Note right of Private Master: Change
    Integration-->>Private Master: Pull/Fetch ...
    Note right of Private Master: Test
    Private Master-->>Integration: Push ...
    Note left of Integration: Test
    Integration-->>Master/Main: Push ...
    Note left of Master/Main: Release
```
## Healthy Branch
_On each commit, perform automated checks, usually building and running tests, to ensure there are no defects on the branch_

There is an immense value in keeping the Integration branch healthy. If the integration is healthy then a developer can start a new piece of work by just pulling the current integration codeline and not be tangled up in defects that get in the way of their work. 
A healthy integration also smooths the path to a release. A new release can be built at any time from the head of the integration. 
Also we tend to stick to a frequent commit pattern, because frequent integration increases the frequency of merges but reduces their complexity and risk. Frequent integration also alerts teams to conflicts much more quickly. 

## Release Branch
The integration codeline is an active branch, with regular drops of new and modified code. Keeping it healthy is important so that when people start new work, they are starting off a stable base. If it's healthy enough, you can also release code directly from integration to main/master.

``` mermaid
gitGraph
    commit id: "Initial"
    branch integration
    commit id:"Feature A"
    commit id:"Feature B"
    commit id:"Feature C"
    commit id:"Feature D"
    checkout main
    merge integration
    commit id:"Release A"
    checkout integration
    commit id:"Feature E"
```

## Hotfix Branch

A branch to capture work to fix an urgent production defect.
If a serious bug appears in production, then it needs to be fixed as soon as possible.

Hotfix work needs to be done in source control, so that the team can properly record and collaborate on it. They can do this by opening a branch at the latest released version and applying any changes for the hotfix on that branch.


``` mermaid
%%{init: { 'logLevel': 'debug', 'theme': 'base', 'gitGraph': {'showBranches': true, 'showCommitLabel':true,'mainBranchName': 'main'}} }%%
gitGraph
    commit id: "Release A"
    commit id: "Release B"
    branch hotfix
    checkout hotfix
    commit
    commit id: "Hotfix_1"
    checkout main
    merge hotfix
    commit id: "Release B_Hotfix_1"
    commit id: "Release C"
```

## References:
* [Patterns for Managing Source Code Branches](https://martinfowler.com/articles/branching-patterns.html#Git-flow)
* [GitHub  Flow](http://scottchacon.com/2011/08/31/github-flow.html)
* [Atlassian Git Tutorial](https://www.atlassian.com/git/tutorials/comparing-workflows)