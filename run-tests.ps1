$yaml = Get-Content "test-config.yml"

$suiteLine = $yaml | Where-Object { $_ -match "^suiteFile:" }

$suiteFile = ($suiteLine -split ":", 2)[1].Trim()

Write-Host "Suite file from YAML: $suiteFile"

mvn clean test "-DsuiteFile=$suiteFile"